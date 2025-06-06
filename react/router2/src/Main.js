import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

function Main(){
	let [data, setData] = useState("");
	const location = useLocation();

	useEffect(()=>{
		let isSignup = false;
	
		if(location.state != null){
			isSignup = location.state.res;
		}
	
		if(isSignup == true){
			alert("회원가입에 성공했습니다.");
			//회원가입 후 새로고침 해도 알림창이 안 뜨게 하는 코드
			//React Router에서 location.state를 럾애는 공식적인 방법은 없음.
			//그래서 어래 코드로 지움
			window.history.replaceState({}, document.title);
		}
	}, [location.state]);

	fetch("/api/test")
	.then(res=>res.text())
	.then(res=>setData(res));

	return(
		<div>
			<h1>메인</h1>
			<h2>{data}</h2>
		</div>
	)
}

export default Main;