import { useState } from 'react'
import { Grid, Input, Select, Card, Button } from '@heroui/react'
import ToolCard from '../../components/ToolCard'
import useTools from '../../hooks/useTools'

const ToolCatalog = () => {
    const { data: tools, isLoading } = useTools()
    const [filters, setFilters] = useState({
        category: '',
        searchQuery: '',
        availability: 'available'
    })

    return (
        <div className="p-6">
            <div className="flex gap-4 mb-6">
                <Input
                    placeholder="Search tools..."
                    value={filters.searchQuery}
                    onChange={(e) => setFilters({...filters, searchQuery: e.target.value})}
                />
                <Select
                    label="Category"
                    options={['Gardening', 'Construction', 'Woodworking']}
                    value={filters.category}
                    onChange={(value) => setFilters({...filters, category: value})}
                />
                <Select
                    label="Availability"
                    options={['Available', 'All']}
                    value={filters.availability}
                    onChange={(value) => setFilters({...filters, availability: value})}
                />
            </div>

            <Grid cols={3} gap={4}>
                {tools?.map(tool => (
                    <ToolCard
                        key={tool.id}
                        tool={tool}
                        onReserve={() => handleReserve(tool)}
                    />
                ))}
            </Grid>
        </div>
    )
}
