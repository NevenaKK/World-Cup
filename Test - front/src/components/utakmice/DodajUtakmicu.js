import React, { useCallback, useEffect, useState } from "react";
import TestAxios from "../../apis/TestAxios";
import { useNavigate } from "react-router-dom";
import{jwtDecode} from 'jwt-decode'
import {Form, Button, Col, Row, Table } from "react-bootstrap";

const DodajUtakmicu=()=>{

    const[reprezentacije,setReprezentacije]=useState([])

    const[novaUtakmica,setNovaUtakmice]=useState({
        repAid:"",
        repBid:""
    })

    const navigate=useNavigate();

    const getReprezentacije=useCallback(()=>{
        TestAxios.get("/reprezentacije")
            .then(res=>{
                console.log(res)
                setReprezentacije(res.data)
                
            })
            .catch(()=>{
                alert("Neuspesno dobavljanje !")
            })
    },[])

 
    useEffect(()=>{
        getReprezentacije()
    },[])

    const dodajUtakmicu=()=>{
        TestAxios.post("/utakmice",{
            repAid:novaUtakmica.repAid,
            repBid:novaUtakmica.repBid

        })
            .then((res)=>{
                console.log(res.data)
                navigate("/utakmice")
                
            })
            .catch((error)=>{
                if(error.message==="Request failed with status code 406")
                alert("Ne mogu biti dve iste reprezentacije !")
            else
                alert("Neuspesno dobavljanje !")
            })
        
    }

    const inputValueChanged=(e)=>{
        const {name,value}=e.target  
        setNovaUtakmice({...novaUtakmica,[name]:value})

        console.log({[e.target.name]: e.target.value})
    }
   



    return(
        <Row>
                <Col > 

               
                    <Form>

                    <Row>
                    <Col>
                        <Form.Group>
                        <Form.Label>Reprezentacija A</Form.Label>
                        <Form.Control  as='select' name="repAid" onChange={inputValueChanged} >
                            <option></option>
                            {
                                reprezentacije.map((reprezentacija)=>{
                                    return <option key={reprezentacija.id} value={reprezentacija.id} >{reprezentacija.skraceniNaziv}</option>
                                })
                            }
                        </Form.Control>
                        </Form.Group>
                        </Col>

                        <Col>
                        <Form.Group>
                        <Form.Label>Reprezentacija B</Form.Label>
                        <Form.Control  as='select' name="repBid" onChange={inputValueChanged} >
                            <option> </option>
                            {
                                reprezentacije.map((reprezentacija)=>{
                                    return <option key={reprezentacija.id} value={reprezentacija.id} >{reprezentacija.skraceniNaziv}</option>
                                })
                            }
                        </Form.Control>
                        </Form.Group>
                        </Col>
                        </Row>

                        <br/>
                        <Button onClick={()=>dodajUtakmicu()}>Kreiraj utakmicu</Button>
                        <br/>

                    </Form>

                </Col>
                </Row>
    )

}

export default DodajUtakmicu