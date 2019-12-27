import React, { Component } from 'react'
import PropTypes from 'prop-types';
import SelectField from '@material-ui/core/Select';
import InputLabel from '@material-ui/core/InputLabel'
import FormControl from '@material-ui/core/FormControl'
import MenuItem from '@material-ui/core/MenuItem';
import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import axios from 'axios';
import { withStyles } from '@material-ui/core';
import RipoutList from '../ripoutList/RipoutList';
import Box from '@material-ui/core/Box';

const styles = theme => ({
    root: {
        flexGrow: 1,
    },
    menuButton: {
        marginRight: theme.spacing(2),
    },
    title: {
        flexGrow: 1,
    },
});

class OpenRoutings extends Component {
    state = {
        apiUrl: 'http://localhost:8080/ripout',
        routing: '',
        routings: [],
        ripouts: []
    }

    onFindOpenRoutings = (e) => {
        axios.get(`${this.state.apiUrl}/openroutings`)
            .then(res => this.setState({ routings: res.data }))
            .catch(err => console.log());

        console.log('Find open routings: ' + this.state.routings);
    }

    onSelectOpenRouting = (e) => {
        console.log('Selected routing: ' + e.target.value);
        this.setState({ routing: e.target.value });
        axios.get(`${this.state.apiUrl}/active/${e.target.value}`)
            .then(res => this.setState({ ripouts: res.data }))
            .catch(err => console.log());

        console.log('Find Assigned Ripouts: ' + this.state.ripouts);
    }

    onReset = (e) => this.setState({ routings: [] });

    render() {
        if (this.state.routings.length === 0) {
            /**
             * Get list of open routings
             */
            return (
                <div style={{ paddingTop: 10 }}>
                    <Button onClick={this.onFindOpenRoutings} color="primary" variant="contained">Find Open Routings</Button>
                </div>
            )
        } else {
            if (this.state.routing.length > 0) {
                return (
                    /**
                     * For selected routing, get open Ripout records
                     * Param name here must be used in target component.  Can't rename it.
                     */
                    <RipoutList routing={this.state.routing} ripouts={this.state.ripouts} />
                )
            }
        }
        return (
            /**
             * Display the list of open routings
             */
            <div>
                <Box mx="auto" border={1} color="grey.400" bgcolor="grey.200" p={1}>
                    <FormControl style={{ paddingTop: 10, width: 200, display: 'flex' }}>
                        <InputLabel>Open Routings</InputLabel>
                        <SelectField
                            name="MenuItem"
                            value={this.state.routing}
                            onChange={this.onSelectOpenRouting}
                        >
                            {this.state.routings.map(routing => (
                                <MenuItem key={routing} value={routing}>{routing}</MenuItem>
                            ))}
                        </SelectField>
                    </FormControl>
                </Box>
                <div style={{ paddingTop: 20 }}>
                    <ButtonGroup variant="contained" >
                        <Button onClick={this.onReset} color="" variant="contained">Cancel</Button>
                        {/* <Button onClick={this.onOK} color="primary" variant="contained">OK</Button> */}
                    </ButtonGroup>
                </div>
            </div>
        )
    }
}

export default OpenRoutings;
