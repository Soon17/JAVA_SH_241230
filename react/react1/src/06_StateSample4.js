import { useState } from "react";

/*
버튼을 클릭하면
input에 입력된 내용이
오늘의 할 일에 등록되는 작업
*/
function StateSample4(){
	let [todo, setTodo] = useState("");
	let [todoList, setTodoList] = useState([]);
	function addTodo(e){
		e.preventDefault();
		if(todo.trim().length == 0){
			alert("할 일을 입력하세요");
			return;
		}
		setTodoList([...todoList, todo]);
		setTodo("");
	}
	return(
		<div>
			<form onSubmit={addTodo}>
				<input type="text" onChange={(e)=>setTodo(e.target.value)} value={todo}/>
				<button type="submit">등록</button>
			</form>
			<h1>오늘의 할 일</h1>
			<ul>
				{
					todoList.map((v, i, arr)=>{
						return <li key={i}>{v}</li>
					})
				}
			</ul>
		</div>
	)
}

export default StateSample4;