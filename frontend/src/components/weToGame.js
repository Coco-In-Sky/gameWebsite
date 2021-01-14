import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import welcomeComponent from './welcomeComponent.js'

class weToGame extends Component{
    render(){
        return(
            <div className="weToGame">
               <Router>
                   <>
                       <HeaderComponent/>
                       <Switch>
                           // <Route path="/" exact component={LoginComponent}/>
                           // <Route path="/login" component={LoginComponent}/>
                           // <AuthenticatedRoute path="/welcome/:name" component={WelcomeComponent}/>
                           // <AuthenticatedRoute path="/todos/:id" component={TodoComponent}/>
                           // <AuthenticatedRoute path="/todos" component={ListTodosComponent}/>
                           // <AuthenticatedRoute path="/logout" component={LogoutComponent}/>

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