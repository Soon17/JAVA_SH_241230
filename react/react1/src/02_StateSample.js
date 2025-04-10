import { ClickButton } from "./Button";
import { useState } from "react";

function StateSample(){
	let [page, setPage] = useState(2);
	const maxPage = 10;

	function decrease(){
		page = page + (-1);
		if(page < 1) page = maxPage;
		setPage(page);
	}

	const increase = function(){
		page = page + 1;
		if(page > maxPage) page = 1;
		setPage(page);
	}

	function add(amount){
		page = page + amount;
		if(page > maxPage) page = 1;
		if(page < 1) page = maxPage;
		setPage(page);
	}

	return(
		<div>
			{/* <ClickButton text={"-"} click={decrease}/> */}
			<ClickButton text={"-"} click={()=>add(-1)}/>
			<span>{page}</span>
			<span>/{maxPage}</span>
			<ClickButton text={"+"} click={()=>add(1)}/>
			{/* <ClickButton text={"+"} click={()=>increase()}/> */}
		</div>
	);
}

export default StateSample;