import { DatePicker, Modal } from '@heroui/react'
import { useState } from 'react'

const ReservationCalendar = ({ tool }) => {
    const [selectedDates, setSelectedDates] = useState({
        start: null,
        end: null
    })

    return (
        <Modal title={`Reserve ${tool.name}`}>
            <div className="space-y-4">
                <DatePicker
                    label="Pickup Date"
                    minDate={new Date()}
                    value={selectedDates.start}
                    onChange={(date) => setSelectedDates({...selectedDates, start: date})}
                />
                <DatePicker
                    label="Return Date"
                    minDate={selectedDates.start || new Date()}
                    value={selectedDates.end}
                    onChange={(date) => setSelectedDates({...selectedDates, end: date})}
                />
                <Button
                    color="primary"
                    disabled={!selectedDates.start || !selectedDates.end}
                    onClick={handleReservation}
                >
                    Confirm Reservation
                </Button>
            </div>
        </Modal>
    )
}
