import axios from 'axios';
import { useState } from 'react';

type Props = {

}

const CreateRoutine = (_props: Props) => {
    const [routine, setRoutine] = useState<Array<string>>([]);
    const [selectedBodyParts, setSelectedBodyParts] = useState<Array<string>>([]);
    let routineText = null;
    if (routine.length > 0) {
        const routineExercisesText = routine.map((exercise: string) => (<li key={exercise}>{exercise}</li>));
        routineText = (
            <div>
                <h4>Here is your routine:</h4>
                <ol>
                    {routineExercisesText}
                </ol>
            </div>
        );
    }

    const onBodyPartSelected = (e: React.ChangeEvent<HTMLSelectElement>) => {
        const selectedValues = Array.from(e.target.selectedOptions, (option) => option.value.toString());
        setSelectedBodyParts(selectedValues);
    };
    const bodyPartOptions =
        ["Chest", "Triceps", "Shoulders", "Legs", "Abs"]
            .map(option => (
                <option value={option} key={option}>
                    {option}
                </option>
            ));
    const bodyPartSelector = (
        <select name="body_parts" id="body_parts" multiple onChange={onBodyPartSelected}>
            {bodyPartOptions}
        </select>
    );

    return (
        <div>
            {bodyPartSelector}
            <br />
            <button onClick={() =>
                axios.get('/api/create_routine', {
                    params: {
                        body_parts: selectedBodyParts
                    }
                }).then(response => setRoutine(response.data))
            }>
                Create New Routine
            </button>
            {routineText}
        </div >
    );

};

export default CreateRoutine