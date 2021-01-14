import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import welcomeComponent from './welcomeComponent.js'
import HeaderComponent from './HeaderComponent.js'
import FooterComponent from './FooterComponent.js'
import ErrorComponent from './ErrorComponent.js'


class weToGame extends Component{
    render(){
        return(
            <div className="weToGame">
               <Router>
                   <>
                       <Switch>
                           <Route component={ErrorComponent}/>
                       </Switch>
                       <FooterComponent/>
                   </>
               </Router>
            </div>
        )
    }
}

export default weToGame