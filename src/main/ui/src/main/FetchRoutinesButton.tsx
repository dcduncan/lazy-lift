import axios from 'axios';

type Props = {
  onClick: (data: string) => void,
  text: string,
}

const FetchRoutinesButton = ({ onClick, text }: Props) => (
  <button onClick={() => axios.get('/api/routines').then(response => onClick(response.data))}>
    {text}
  </button>
)

export default FetchRoutinesButton