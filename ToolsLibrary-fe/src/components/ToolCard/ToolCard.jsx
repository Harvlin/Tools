import { Card, Badge, Button } from '@heroui/react'

const ToolCard = ({ tool }) => {
    return (
        <Card
            imageSrc={tool.imageUrl}
            imageAlt={tool.name}
            header={
                <div className="flex justify-between items-center">
                    <h3 className="text-xl font-semibold">{tool.name}</h3>
                    <Badge color={tool.isAvailable ? 'success' : 'error'}>
                        {tool.isAvailable ? 'Available' : 'Reserved'}
                    </Badge>
                </div>
            }
        >
            <div className="space-y-2">
                <p className="text-gray-600">{tool.description}</p>
                <div className="flex gap-2">
                    <Button variant="outline" onClick={showDetails}>
                        Details
                    </Button>
                    <Button
                        color="primary"
                        disabled={!tool.isAvailable}
                        onClick={handleReserve}
                    >
                        Reserve
                    </Button>
                </div>
            </div>
        </Card>
    )
}
