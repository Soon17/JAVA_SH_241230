import { useState } from "react";


function App2(){

	let [h, setH] = useState("");

	function myHobby(e){
		let {value, name, checked} = e.target;
		setH(value);
	}
	
	return (
		<div>
			<label>
				<input type="radio" value={"독서"} name="hobby" onChange={myHobby}/>독서
			</label>
			<label>
				<input type="radio" value={"운동"} name="hobby" onChange={myHobby}/>운동
			</label>
			<label>
				<input type="radio" value={"음악감상"} name="hobby" onChange={myHobby}/>음악감상
			</label>
			<h1>{h}</h1>
		</div>
	)
}

export default App2;