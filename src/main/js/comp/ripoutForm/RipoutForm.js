import React, { Component } from 'react';
import { withStyles } from '@material-ui/core/styles';
import axios from 'axios';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import Box from '@material-ui/core/Box';
import { Input } from '@material-ui/core';
import Dialog from '@material-ui/core/Dialog';
import DialogTitle from '@material-ui/core/DialogTitle';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';

const classes = withStyles(theme => ({
  root: {
    '& > *': {
      margin: theme.spacing(1)
    },
    Dialog: {}
  },
  input: {
    backgroundColor: 'grey.200'
  }
}));

class RipoutForm extends Component {
  state = {
    apiUrl: 'http://localhost:8080/ripout',
    dlgOpen: false,
    xref: {},
    selectedXREF: {},
    ripout: {},
    respCode: {}
  };

  constructor(props) {
    super(props);

    this.state.xref = this.props.selectedXREF;
    // ex handler here

    this.getRipout(this.state.xref);
    const ripout = this.state.ripout;
    // ex handler here
  }

  getRipout = () => {
    console.log('Find XREF: ' + this.state.xref);

    // axios.get(`${this.state.apiUrl}/123`) // use to drive check in render()
    axios
      .get(`${this.state.apiUrl}/` + this.state.xref)
      .then(res => this.setState({ ripout: res.data }))
      .catch(err => console.log());
  };

  handleOpen = ripout => {
    this.setState({ open: true });
  };

  handleClose = () => {
    this.setState({ open: false });
  };

  signRoutingStep = () => {
    console.log('Sign routing: ' + this.state.xref);

    axios
      .put(`${this.state.apiUrl}/progress/${this.state.xref}`)
      .then(res => this.setState({ respCode: res.data }))
      .catch(err => console.log());

    console.log('Signing response: ' + this.state.respCode);
    this.handleClose();
  };

  render() {
    if (this.state.selectedXREF.length === 0) {
      return <strong>XREF required</strong>;
    }

    // this check is incorrect
    if (this.state.ripout.length === 0) {
      return (
        <strong>
          No Ripout record available for XREF + &nbsp;&nbsp;{' '}
          {this.state.selectedXREF}{' '}
        </strong>
      );
    }

    const ripout = this.state.ripout;
    const actions = [
      <Button label='Close' primary={true} onClick={this.handleClose}>
        Close
      </Button>
    ];

    return (
      <div>
        <div className={classes.root}>
          <Box mx='auto' border={1} color='grey.400' bgcolor='grey.200' p={1}>
            <Grid container spacing={4}>
              <Grid container item xs={12} spacing={1}>
                <TextField
                  label='XREF'
                  value={ripout.xref}
                  className={classes.textField}
                />
                <TextField
                  label='SEQ'
                  value={ripout.xrefSeq}
                  className={classes.textField}
                />
                <TextField
                  label='Nuclear'
                  value={ripout.nuclear}
                  className={classes.textField}
                />
                <TextField
                  label='Ripout Num'
                  value={ripout.ripoutNo}
                  className={classes.textField}
                />{' '}
                {/* </Grid>

            <Grid container item xs={8} spacing={1}> */}
                <TextField
                  label='Originator'
                  value={ripout.originator}
                  className={classes.textField}
                />
                <TextField
                  label='Badge'
                  value={ripout.badge}
                  className={classes.textField}
                />
                <TextField
                  label='Originator Date'
                  value={ripout.originationDate}
                  className={classes.textField}
                />
                <TextField
                  label='Status'
                  value={ripout.status}
                  className={classes.textField}
                />{' '}
                {/* </Grid>

            <Grid container item xs={8} spacing={1}> */}
                <TextField
                  label='Work Order'
                  value={ripout.workOrder}
                  className={classes.textField}
                />
                <TextField
                  label='WPPN'
                  value={ripout.wppn}
                  className={classes.textField}
                />
                <TextField
                  label='Sys/Comp'
                  value={ripout.sysComp}
                  className={classes.textField}
                />
                <TextField
                  label='PSA/New'
                  value={ripout.psaNew}
                  className={classes.textField}
                />
              </Grid>
            </Grid>
          </Box>
          <p /> {/* <Grid container item xs={10} spacing={2}> */}
          <ButtonGroup
            style={{
              float: 'right',
              marginRight: 20
            }}>
            <Button
              variant='contained'
              color='primary'
              onClick={() => this.handleOpen(ripout)}>
              Sign
            </Button>
            <div style={{ width: 20 }} />
            <Button variant='contained'>Kick</Button>
            <div style={{ width: 20 }} />
            <Button color='secondary' variant='contained'>
              Red Mat
            </Button>
          </ButtonGroup>
          {/* </Grid> */}{' '}
        </div>
        <div>
          <Dialog
            aria-labelledby='simple-dialog-title'
            open={this.state.open}
            onClose={this.handleClose}>
            <DialogTitle id='simple-dialog-title'>
              Sign Open Routing for {ripout.routing}{' '}
            </DialogTitle>
            {/* <DialogContent>
              <DialogContentText>
                Routing will progress from {ripout.routing}
              </DialogContentText>
            </DialogContent> */}
            <div style={{ width: 20 }} />{' '}
            {/* <Button fullWidth="false" maxWidth="sm" variant="contained" color="secondary" onClick={() => this.handleClose()}>Close</Button> */}
            <DialogActions fullWidth='true' maxwidth='lg'>
              <Box mx='auto' border={1} color='grey.400' p={1}>
                <Input
                  label='Add Attachment'
                  disableUnderline
                  accept='image/*'
                  className={classes.input}
                  id='contained-button-file'
                  multiple
                  type='file'
                />{' '}
                {/* <label htmlFor='contained-button-file'>
                  <Button color='primary' component='span' variant='contained'>
                    Attachment
                  </Button>
                </label> */}{' '}
              </Box>
              <div style={{ height: 30 }} />
              <Button
                variant='contained'
                color='secondary'
                onClick={() => this.signRoutingStep()}>
                Sign
              </Button>

              <Button
                variant='contained'
                onClick={this.handleClose}
                color='primary'>
                Cancel
              </Button>
            </DialogActions>
          </Dialog>
        </div>
      </div>
    );
  }
}
export default RipoutForm;
