import './CardClient.css'
import React from 'react'

const CardClient = ({Client}) => {
    return (
        <div className="card">

            <div className='row header'>
                <div className='col'>
                    <p>Nome</p>
                </div>
                <div className='col'>
                    <p>CNPJ</p>
                </div>
            </div>
            
            <div className='row'>
                <div className='col'>
                    <p>{Client.name}</p>
                </div>
                <div className="col">
                    <p>{Client.cnpj}</p>
                </div>
            </div>

            <div>
                
            </div>

        </div>
    )
}

export default CardClient