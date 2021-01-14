import React, { Component } from 'react'
import { Link } from 'react-router-dom'


class HeaderComponent extends Component {
    render() {

        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><a href="http://www.weToGame.com" className="navbar-brand">in28Minutes</a></div>
                    <ul className="navbar-nav">

                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">

                    </ul>
                </nav>
            </header>
        )
    }
}

export default HeaderComponent