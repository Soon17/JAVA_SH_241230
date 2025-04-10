import PropTypes from 'prop-types';

function Button(){
	return(
		<button>기본 버튼</button>
	);
}

function Button1(props){
	return(
		<button>{props.text}</button>
	);
}

function Button2({text}){
	return(
		<button>{text}</button>
	);
}

function Button3({text, style}){
	return(
		<button style={style}>{text}</button>
	);
}

function Button4(props){
	return(
		<button style={props.style}>{props.text}</button>
	);
}


function ClickButton({text = "버튼", style, click}){
	return(
		<button style={style} onClick={click}>{text}</button>
	);
}

Button.proTypes = {
	text : PropTypes.string,
	style : PropTypes.object
}

Button.defaultProps = {
	text : "버튼"
}

export {Button, Button1, Button2, Button3, Button4, ClickButton};