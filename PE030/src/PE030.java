public class PE030 {

	public static void main(String[] args) {
		// because 1^5=1 doesn't count
		int sum = 0;
		// ugly but it works
		// there's no need to go higher
		for(Integer a=0; a<10; a++){
			for(Integer b=0; b<10; b++){
				for(Integer c=0; c<10; c++){
					for(Integer d=0; d<10; d++){
						for(Integer e=0; e<10; e++){
							for(Integer f=0; f<10; f++){
								String concatenatedString = a.toString()+b.toString()+c.toString()+d.toString()+e.toString()+f.toString();
								
								Integer concatenatedInteger = Integer.parseInt(concatenatedString);
								Integer number = (int) (Math.pow(a,5)+Math.pow(b,5)+Math.pow(c,5)+Math.pow(d,5)+Math.pow(e,5)+Math.pow(f,5));

								if (concatenatedInteger.intValue() == number.intValue() && number.intValue()!=1 && number.intValue()!=0) {
									System.out.println("Number: " + number);
									sum += number;
								}
							}
						}
					}
				}
			}
		}
		System.out.println("\nANSWER: " + sum);
	}

}
