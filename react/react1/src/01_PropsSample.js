import { Button, Button1, Button2, Button3, Button4 } from "./Button";

function PropsSample() {
  return (
    <div>
      <Button/>
      <Button1 text="버튼1"/>
      <Button2 text="버튼2"/>
      <Button3 text={"버튼3"} style={{color : "red", backgroundColor : "#fff"}}/>
      <Button4 text={"버튼4"} style={{color : "red", backgroundColor : "#fff"}}/>

    </div>
  );
}

export default PropsSample;
