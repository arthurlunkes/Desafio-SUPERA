import './CardClient.css'
import React from 'react'

const CardClient = ({Client, editClient, deleteClient}) => {
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

            <div className='buttons'>
                <button className='btn btn-warning' onClick={() => editClient(Client)}>Editar</button>
                <button className='btn btn-danger' onClick={() => deleteClient(Client.id)}>Excluir</button>
            </div>

        </div>
    )
}

export default CardClient