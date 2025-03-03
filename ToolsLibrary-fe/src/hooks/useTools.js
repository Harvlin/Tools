import { useQuery } from 'react-query'
import { fetchTools } from '../api/toolService'

export const useTools = () => {
    return useQuery('tools', fetchTools, {
        refetchInterval: 5000, // Real-time updates
        staleTime: 30000
    })
}
