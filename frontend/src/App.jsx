import {useState,useEffect} from 'react'


export default function App() {
    const [subs, setSubs] = useState([]);
    const [form, setForm] = useState({
        name: "",
        cost: "",
        billingCycle:"MONTHLY",
        subCategory: "ENTERTAINMENT",
        notes: "",
        nextRenewalDate: "",
    })

    useEffect(() => {
      fetchSubscriptions();
    }, []);

    function fetchSubscriptions(){
        fetch('http://localhost:8081/api/subscriptions')
                .then(response => response.json())
                .then(data => setSubs(data));
        }

    function handleSubmit(e) {
        e.preventDefault();

         fetch('http://localhost:8081/api/subscriptions',{
                method: 'POST',
                headers: {'Content-Type':'application/json'},
                body: JSON.stringify(form)

                })
                .then(response => response.json())
                .then(result => console.log(result))
                .then(result => setForm({name: "",
                                                 cost: "",
                                                 billingCycle:"MONTHLY",
                                                 subCategory: "ENTERTAINMENT",
                                                 notes: "",
                                                 nextRenewalDate: "",}))

         .then(()=>fetchSubscriptions());
      }

  function handleDelete(id){

        fetch('http://localhost:8081/api/subscriptions/'+ id.toString(),{method: 'DELETE'})
        .then(()=>fetchSubscriptions());
      }

  return(
      <div>
          <h1> Welcome to Subscription Tracker! </h1>
          <ul>
              {subs.map(sub => (
                  <li key ={sub.id}>{sub.name} <button onClick={() => handleDelete(sub.id)}>Delete</button> </li>
              ))}
          </ul>


          <input name="Subscription Name" placeholder = "Enter Subscription Name"
          value={form.name} onChange={(e) => setForm({...form, name: e.target.value})} />

          <input name="Subscription Cost" placeholder = "Enter Subscription Cost"
          value={form.cost} onChange={(e) => setForm({...form, cost: e.target.value})} />


          <select name="Subscription Billing Cycle" value={form.billingCycle} onChange={(e) => setForm({...form, billingCycle: e.target.value})}>
              <option value="MONTHLY">Monthly</option>
              <option value="YEARLY">Yearly</option>
              <option value="WEEKLY">Weekly</option>
          </select>

          <select name="Subscription Category" value={form.subCategory} onChange={(e) => setForm({...form, subCategory: e.target.value})}>
                        <option value="TECHNOLOGY">Technology</option>
                        <option value="ENTERTAINMENT">Entertainment</option>
                        <option value="LIFESTYLE">Lifestyle</option>
                        <option value="UTILITY">Utility</option>
                        <option value="CONSUMABLES">Consumables</option>
                        <option value="HEALTH">Health</option>
          </select>

          <input name="Subscription Notes" placeholder = "Enter Notes (optional)"
          value={form.notes} onChange={(e) => setForm({...form, notes: e.target.value})} />

          <input name="Next Subscription Renewal" type = "date" value={form.nextRenewalDate} onChange ={(e)=> setForm({...form, nextRenewalDate: e.target.value})} />

           <p>{JSON.stringify(form)}</p>

           <form onSubmit={handleSubmit}>

                 <input type="submit" />
               </form>
      </div>
      );
}


