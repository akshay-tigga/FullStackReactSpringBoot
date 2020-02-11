import React from 'react'

function FooterComponent() {
    return (
        <footer id="main-footer">
            <div className="container">
                <div className="row">
                    <div className="col">
                        <p className="lead text-center">
                            Copyright &copy; <span id="year">{new Date().getFullYear()}</span> Akshay
                        </p>
                    </div>
                </div>
            </div>
        </footer>
    )
}

export default FooterComponent