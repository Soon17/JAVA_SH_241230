import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Signup(){

	// let [id, setId] = useState("");
	// let [pw, setPw] = useState("");
	// let [pw2, setPw2] = useState("");
	// let [email, setEmail] = useState("");

	// const submit = function (e){
	// 	e.preventDefault();
	// 	console.log(id);
	// 	console.log(pw);
	// 	console.log(pw2);
	// 	console.log(email);
	// }

	const navigate = useNavigate();

	let [data, setData] = useState({
		me_id : "",
		me_pw : "",
		me_pw2 : "",
		me_email : ""
	});


	const change = e => {
		setData({
			...data,
			[e.target.name] : e.target.value
		})
	} 

	const checkRegex = e => {
		//유효성 검사
		if(data.me_id === ""){
			alert("아이디는 필수 항목입니다.");
			return false;
		}
		if(data.me_pw === ""){
			alert("비밀번호는 필수 항목입니다.");
			return false;
		}
		if(data.me_pw2 !== data.me_pw){
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		if(data.me_email === ""){
			alert("이메일은 필수 항목입니다.");
			return false;
		}

		return true;
	}

	const clearData = e => {
		setData({
			me_id : "",
			me_pw : "",
			me_pw2 : "",
			me_email : ""
		})
	}

	const submit = function (e){
		e.preventDefault();

		if(!checkRegex()) return;

		fetch("api/react/signup", {
			method : "post",
			body : JSON.stringify(data),
			headers : {
				"Content-type" : "application/json"
			}
		})
		.then(res=>res.json())
		.then(res=>{
			if(res){
				navigate("/", {
					state : {
						res : res
					}
				});
			} else {
				alert("회원가입에 실패했습니다.");
				clearData();
			}
		});
	}

	return (
		<div className="container">
			<h1>회원가입</h1>
			<form onSubmit={submit}>
				<div className="mb-3 mt-3">
					<label htmlFor="id" className="form-label">아이디:</label>
					<input type="text" className="form-control" id="id" placeholder="아이디를 입력하세요" value={data.me_id} name="me_id"
					onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="pw" className="form-label">비번:</label>
					<input type="password" className="form-control" id="pw" placeholder="비밀번호를 입력하세요" value={data.me_pw} name="me_pw"
					onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="pw2" className="form-label">비번확인:</label>
					<input type="password" className="form-control" id="pw2" placeholder="비밀번호를 다시 입력하세요" value={data.me_pw2} name="me_pw2"
					onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="email" className="form-label">이메일:</label>
					<input type="email" className="form-control" id="email" placeholder="이메일을 입력하세요" value={data.me_email} name="me_email"
					onChange={change}/>
				</div>
				<button className="btn btn-outline-success col-12">회원가입</button>
			</form>
		</div>
	)
}

export default Signup;