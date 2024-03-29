import React, { useCallback, useEffect, useState } from "react";
import TestAxios from "../../apis/TestAxios";
import { useNavigate } from "react-router-dom";
import{jwtDecode} from 'jwt-decode'
import {Form, Button, Col, Row, Table } from "react-bootstrap";

const Utakmica=()=>{

    const token=window.localStorage.getItem("jwt")
    const decoded=token?jwtDecode(token):null
    const isAdmin=decoded?.role?.authority==="ROLE_ADMIN"


    const [pageNo,setPageNo]=useState(0);
    const [pageMax,setPageMax]=useState(0);
    const[reprezentacije,setReprezentacije]=useState([])

    const [utakmice,setUtakmice]=useState([])

    const [searchParams,setSearchParams]=useState([]) 

    const navigate=useNavigate();

    const getUtakmice=useCallback(()=>{
        TestAxios.get(`/utakmice?pageNo=${pageNo}`,{
            params:{
                repA:searchParams.repAid,
                repB:searchParams.repBid            
            }
        })
            .then(res=>{
                console.log(res)

                setUtakmice(res.data)
                setPageMax(res.headers['total-pages'])
               
                
            })
            .catch((error)=>{
                if(error.message==="Request failed with status code 406")
                    alert("Ne mogu biti dve iste reprezentacije !")
                else
                    alert("Neuspesno dobavljanje !")
            })
    },[pageNo,searchParams])


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

    const obrisiUtakmicu=(utakmicaId)=>{
        TestAxios.delete("/utakmice/"+utakmicaId)
            .then((res)=>{
                console.log(res)
                window.location.reload()
            })
            .catch(()=>{
                alert("Neuspesno brisanje !")
            })
    }

    const dodajUtakmicu=()=>{
        navigate("/utakmice/dodaj")
    }


    useEffect(()=>{
        getUtakmice()
        getReprezentacije()
    },[pageNo])

    const handleChange=(e)=>{
        const{name,value}=e.target 
        setSearchParams({...searchParams,[name]:value})
        // console.log({[e.target.name]: e.target.value}) 
    }

    const dodajA=(utakmicaId,repAid)=>{
        TestAxios.put("/utakmice/dodajA/"+utakmicaId,{
            Headers:{'Content-Type': 'application/json'
            }
        })
        .then((res)=>{
            navigate("/utakmice/strelac/"+repAid)

    })
    .catch((error)=>{
        console.log(error)
        alert("Neuspesna izmena")
    })
    }

    const dodajB=(utakmicaId,repBid)=>{
        TestAxios.put("/utakmice/dodajB/"+utakmicaId,{
            Headers:{'Content-Type': 'application/json'
            }
        })
        .then((res)=>{
            navigate("/utakmice/strelac/"+repBid)

    })
    .catch((error)=>{
        console.log(error)
        alert("Neuspesna izmena")
    })
    }

    const renderUtakmice=()=>{
        return utakmice.map((utakmica)=>{
            return(
                <tr key={utakmica.id}>
                    <td>{utakmica.repAime}</td>
                    <td>{utakmica.repBime}</td>
                    <td>{utakmica.brojGolovaA}</td>
                    <td>{utakmica.brojGolovaB}</td>
                    <td><Button variant="info" onClick={()=>dodajA(utakmica.id,utakmica.repAid)}>A+1</Button></td>
                    <td><Button variant="info"onClick={()=>dodajB(utakmica.id,utakmica.repBid)}>B+1</Button></td>
                    <td> {isAdmin && <Button  variant="danger" onClick={()=>obrisiUtakmicu(utakmica.id)}> Obrisi </Button>}</td>
                </tr>

                  
            )      
        })
    }


    const handleSearch=()=>{
        getUtakmice()
    }


    return(
        <Row> 

            <Row><h1>Utakmice</h1></Row>
            <br></br>

                <Row>
                    <Col>
                    <Form>


                    <Row>
                    <Col>
                        <Form.Group>
                        <Form.Label>Reprezentacija A</Form.Label>
                        <Form.Control id="stanje" as='select' name="repAid" onChange={handleChange} >
                        <option value={""}> </option>
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
                        <Form.Control id="stanje" as='select' name="repBid" onChange={handleChange} >
                            <option value={""}> </option>
                            {
                                reprezentacije.map((reprezentacija)=>{
                                    return <option key={reprezentacija.id} value={reprezentacija.id} >{reprezentacija.skraceniNaziv}</option>
                                })
                            }
                        </Form.Control>
                        </Form.Group>
                        </Col>
                        </Row>
                         <br></br>
                        <Button onClick={()=>handleSearch()}>Pretrazi</Button>
                        <br></br>
                    </Form>
                    </Col>

                </Row>


                <Row>
                <Col>
                
               <br></br>
                <div style={{ display: 'flex', justifyContent: "space-between" }}>
                    <span><Button onClick={()=>dodajUtakmicu()} >Nova utakmica</Button>
                    <Button  >Najbolji strelac</Button>
                    
                    </span>
                        <span>
                            <Button style={{ marginRight: '5px'}} disabled={pageNo<=0} onClick={(e)=>setPageNo(pageNo-1)}> Previous</Button>
                            <Button disabled={pageNo>=pageMax-1} onClick={(e)=>setPageNo(pageNo+1)}> Next </Button>
                            
                        
                        </span>
                    </div>

                </Col>
                </Row>


                <Col>
                    <Table className="table-striped table-bordered table-hover">

                        <thead className="table-dark">
                            <tr>
                                <th> Reprezentacija A  </th>
                                <th> Reprezentacija B </th>
                                <th> Golovi A </th>
                                <th> Golovi B </th>
                                <th></th>
                                <th></th>
                                <th></th>
                               
                            </tr>
                        </thead>

                        <tbody>
                           {renderUtakmice()}
                        </tbody>
                    </Table>

                </Col>
                </Row>
    )
}

export default Utakmica;