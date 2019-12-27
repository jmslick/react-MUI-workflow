import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import TitleBar from './comp/titleBar/TitleBar';
import OpenRoutings from './comp/search/OpenRoutings';
import RipoutForm from './comp/ripoutForm/RipoutForm';
import { ThemeProvider as MuiThemeProvider } from '@material-ui/core/styles';

class App extends Component {
  render() {
    return (
      <MuiThemeProvider>
        <div style={{ marginTop: 10, marginLeft: 10, marginRight: 10 }}>
          <TitleBar />
          <div style={{ marginTop: 10, marginLeft: 10, marginRight: 10 }}>
            <OpenRoutings />
          </div>
          {/* <RipoutForm /> */}
        </div>
      </MuiThemeProvider>
    );
  }
}

//export default App;

ReactDOM.render(<App />, document.querySelector('#root'));
//ReactDOM.render(<App />, document.querySelector('#react'));