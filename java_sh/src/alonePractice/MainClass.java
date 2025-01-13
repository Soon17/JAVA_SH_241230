package alonePractice;

import java.util.ArrayList;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MainClass {
	public static void main(String[] args) {
		Word w = new Word("rea", "asd");
		System.out.println(w.getName().contains("ea"));
	}
}

@Data
@AllArgsConstructor
class Word {
	String name;
	String age;
}