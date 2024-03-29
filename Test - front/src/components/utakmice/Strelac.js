import React, { useCallback, useEffect, useState } from "react";
import TestAxios from "../../apis/TestAxios";
import { useNavigate, useParams } from "react-router-dom";
import{jwtDecode} from 'jwt-decode'
import {Form, Button, Col, Row, Table } from "react-bootstrap";
const Strelac=()=>{

    const [igraci,setIgraci]=useState([]);
    const routeParam=useParams()
    const [idParam,setidParam]=useState(0)
    const navigate=useNavigate();

    const getIgraci=useCallback(()=>{
        TestAxios.get("/igraci/rep/"+routeParam.id)
            .then(res=>{
                console.log(res)
                setIgraci(res.data)
                
            })
            .catch(()=>{
                alert("Neuspesno dobavljanje !")
            })
    },[])


    useEffect(()=>{
        getIgraci()
    },[])
    
    const dodajGol=()=>{
        TestAxios.put("/igraci/dodajGol/"+idParam)
        .then(res=>{
            console.log(res)
           navigate("/utakmice")
            
        })
        .catch(()=>{
            alert("Neuspesno dobavljanje !")
        })
    }

    

    

    return(
        
        <Row>
          <Row>Strelac gola </Row>  



                    <Form>
                        <Col>
                        <Form.Group>
                        <Form.Label></Form.Label>
                        <Form.Control  as='select' name="id" onChange={(e)=>setidParam(e.target.value)}>
                            <option value={""}> </option>
                            {
                                igraci.map((igrac)=>{
                                    return <option key={igrac.id} value={igrac.id} >{igrac.ime +" "+ igrac.prezime }</option>
                                })
                            }
                        </Form.Control>
                        </Form.Group>
                        </Col>
                     
                         <br></br>
                        <Button onClick={()=>dodajGol()} >Dodaj gol</Button>
                        <br></br>
                    </Form>
       

        </Row>
    )
}

export default Strelac;