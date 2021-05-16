package com.example.springbootderby.service;

import com.example.springbootderby.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

public class cardService {

    public static boolean isValidCreditCardNumber(String cardNumber) throws Exception {

            // int array for processing the cardNumber
            int[] cardIntArray = new int[cardNumber.length()];

            if (cardNumber.length() < 20) {
                for (int i = 0; i < cardNumber.length(); i++) {
                    char c = cardNumber.charAt(i);
                    cardIntArray[i] = Integer.parseInt("" + c);
                }

                for (int i = cardIntArray.length - 2; i >= 0; i = i - 2) {
                    int num = cardIntArray[i];
                    num = num * 2;  // step 1
                    if (num > 9) {
                        num = num % 10 + num / 10;  // step 2
                    }
                    cardIntArray[i] = num;
                }

                int sum = sumDigits(cardIntArray);  // step 3
                System.out.println(sum);

                if (sum % 10 == 0) return true;
                else return false;
            } else {
                return false;
                //throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error in card number length");
            }
        }



    public static int sumDigits(int[] arr)
    {
        return Arrays.stream(arr).sum();
    }
}
