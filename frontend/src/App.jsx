import {useState,useEffect} from 'react'


export default function App() {
    const [subs, setSubs] = useState([]);

    useEffect(() => {
      fetch('http://localhost:8081/api/subscriptions')
        .then(response => response.json())
        .then(data => setSubs(data));
    }, []);


  return(
      <div>
          <h1> Welcome to Subscription Tracker! </h1>
          <ul>
              {subs.map(sub => (
                  <li key ={sub.id}>{sub.name}</li>

              ))}
          </ul>

      </div>
      );
}


