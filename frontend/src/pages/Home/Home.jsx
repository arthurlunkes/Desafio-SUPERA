import './Home.css'
import React, { useState } from 'react';
import { } from '../../services/AxiosService'

const Home = () => {
    const [name, setName] = useState('');
    const [cnpj, setCnpj] = useState('');
    const [clients, setClients] = useState([]);

    return (
        <div className='container'>

            <div className="form-content">
                <h2>Criar Cliente</h2>
                <div>
                    <label htmlFor="name">Nome</label>
                    <input id='name' type="text" />
                </div>
                <div>
                    <label htmlFor="cnpj">CNPJ</label>
                </div>
                <div className='buttons'>
                    <button>Salvar</button>
                </div>

            </div>
            <div className='backgroud-clients'>
            </div>

        </div>
    );
}

export default Home