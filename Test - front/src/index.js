import React from 'react';
import { createRoot } from 'react-dom/client';
import {Link, Route,BrowserRouter as Router, Routes} from 'react-router-dom';
import Home from './components/Home';
import NotFound from './components/NotFound';
import Login from './components/authorization/Login';
import { logout } from './services/auth';
import { Button, Nav, Navbar, NavbarBrand ,Container} from 'react-bootstrap';
import Utakmica from './components/utakmice/Utakmica';
import DodajUtakmicu from './components/utakmice/DodajUtakmicu';
import Strelac from './components/utakmice/Strelac';



const App = () => {

    if(window.localStorage['jwt']){
        return( 
        
                <Router>

                <Navbar expand bg="dark" variant='dark'>   

                    <NavbarBrand as={Link} to="/"> JWD </NavbarBrand>  
                    <NavbarBrand as={Link} to="/utakmice"> Utakmice </NavbarBrand> 

                    <Nav>
                        <Button onClick={()=>logout()} >Logout</Button>
                    </Nav>
                </Navbar>
    
    		<Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path='/' element={<Home/>} />      
                    <Route path='/utakmice' element={<Utakmica/>} />   
                    <Route path='/utakmice/dodaj' element={<DodajUtakmicu/>} /> 
                    <Route path='/utakmice/strelac/:id' element={<Strelac/>} /> 
                    <Route path='/login' element={<Login/>} />
                    <Route path='*'  element={<NotFound/>}/>
                </Routes>
                </Container>
                </Router>
    
    
        )
    }else{
        return( 
          
                <Router>

                <Navbar expand bg="dark" variant='dark'> 
                     <NavbarBrand as={Link} to="/"> Test </NavbarBrand>  
                     <NavbarBrand as={Link} to="/utakmice"> Utakmice </NavbarBrand>   
                         
                     <Nav.Link as={Link} to="/login" >Login</Nav.Link>
                </Navbar>
                
    		<Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path='/' element={<Home/>} />     
                    <Route path='/utakmice' element={<Utakmica/>} /> 
                    <Route path='/utakmice/dodaj' element={<DodajUtakmicu/>} /> 
                    <Route path='/utakmice/strelac' element={<Strelac/>} /> 
                    <Route path='/login' element={<Login/>} />
                    <Route path='*'  element={<NotFound/>}/>
                </Routes>
  		</Container>
                </Router>
    
    
        
    
        )
    }

    

};


const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App />,
);
 
