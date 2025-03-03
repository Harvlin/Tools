import axios from 'axios'

const API_URL = 'http://localhost:8080/api/tools'

export const fetchTools = async () => {
    const response = await axios.get(API_URL)
    return response.data
}

export const reserveTool = async (toolId, dates) => {
    return await axios.post(`${API_URL}/${toolId}/reserve`, dates)
}
