package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {
	
	private static final String template = "Hello, %s!";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) ||!isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}

	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) ||!isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sub;
	}

	@RequestMapping(value="/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multi(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) ||!isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		Double multi = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return multi;
	}

	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) ||!isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return div;
	}

	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) ||!isNumeric(numberTwo)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		Double mean = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		return mean;
	}

	@RequestMapping(value="/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable(value="number") String number) throws Exception {
		if (!isNumeric(number)){
			throw  new UnsupportedOperationException("Please set a numeric value");
		}
		Double squareRoot = (Double) Math.sqrt(convertToDouble(number));
		return squareRoot;
	}

	private Double convertToDouble(String strNumber){
		if(strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",",".");
		if (isNumeric(number))
		return Double.parseDouble(number);

		return 0D;

	}

	private boolean isNumeric(String strNumber){
		if(strNumber == null)
			return false;
		String number = strNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
