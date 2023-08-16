import './Home.css'
import React, { useState, useEffect } from 'react';
import Card from '../../components/CardClient/CardClient';
import Modal from '../../components/Modal/Modal';
import { getClients, createClient, deleteClient, updateClient } from '../../services/AxiosService'

const Home = () => {
    const [name, setName] = useState('');
    const [cnpj, setCnpj] = useState('');
    const [client, setClient] = useState({});
    const [clients, setClients] = useState([]);
    const [isOpenModal, setIsOpenModal] = useState(false)

    useEffect(() => {
        getClients()
        .then(response => {
            setClients(response.data)
            console.log(response.data)
        })
        .catch(error => {
            console.log(error)
        })
    }, [])

    const createClient = () => {
        createClient(name, cnpj)
        setName('')
        setCnpj('')
    }

    const editClient = (client) => {
        setClient(client)
        openModal()
    }

    const deleteClient = (id) => {
        deleteClient(id)
    }

    const openModal = () => {
        setIsOpenModal(true)
    }

    const closeModal = () => {
        setIsOpenModal(false)
    }

    const renderModal = () => {
        <Modal isOpen={isOpenModal} onClose={closeModal}/>
    }

    return (
        <div className='container'>

            {renderModal()}
            <div className="form-content">

                <h2>Criar Cliente</h2>

                <div className='row'>
                    <div className='col'>
                        <label className='form-label' htmlFor="name">Nome </label>
                        <input
                            id='name'
                            class="form-label"
                            type="text"
                            value={name}
                            onChange={e => setName(e.target.value)}
                        />
                    </div>

                    <div className='col'>
                        <label htmlFor="cnpj">CNPJ </label>
                        <input
                            id="cnpj"
                            type="text"
                            name="cnpj"
                            value={cnpj}
                            onChange={e => setCnpj(e.target.value)}
                        />
                    </div>
                </div>

                <div className='buttons'>
                    <button className="btn btn-primary" onClick={createClient}>Salvar</button>
                </div>

            </div>

            <div className='backgroud-clients'>
                {clients.map(client => (
                    <Card key={client.id} 
                        Client={client} 
                        editClient={editClient}
                        deleteClient={deleteClient}
                    />
                ))}
            </div>

        </div>
    );
}

export default Home