import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.headers.post["Content-Type"] = "application/json";

const request = (method, url, data, headers) => {
    return axios({
      method: method,
      url: url,
      headers: headers,
      data: data,
    });
  };

export const getClients = () => {
   return request('get', '/client'); 
}

export const createClient = (name, cnpj) => {
    return request('post', '/client', {name, cnpj});
}

export const updateClient = (client) => {
    return request('put', `/client`, client);
}

export const deleteClient = (id) => {
    return request('delete', `/client/${id}`);
}