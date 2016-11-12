/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operators;

import java.util.Scanner;

/**
 * @author Stefan-Alexandru Rentea
 */

class AllOperators {
static void forInt() {
    int result, original;
        result = original = 5;
        
        System.out.println("\nint TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (result*2));
        System.out.println("Division: " + result + " / 2 = " + (result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        System.out.println("Binary inclusive OR assignment: var |= 11 : " + (result |= 11));
        System.out.println("Binary AND assignment: var &= 9 : " + (result &= 9));
        System.out.println("Binary exclusive OR assignment: var ^= 2 : " + (result ^= 2));
        System.out.println("Signed right shift assignment: var >>= 5 : " + (result >>= 5));
        System.out.println("Signed left shift assignment: var <<= 10 : " + (result <<= 10));
        System.out.println("Unsigned right shift assignment: var >>>= 3 : " + (result >>>= 3));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result == original)
            System.out.println("Equals: " + result + " == " + original + " : True");
        else
            System.out.println("Equals: " + result + " == " + original + " : False");
        if (result != original)
            System.out.println("Not equal to: " + result + " != " + original + " : True\n");
        else
            System.out.println("Not equal to: " + result + " != " + original + " : False\n");
        
        System.out.println("Miscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        System.out.println("Istanceof: Doesn't work for primitive types!\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (result>>>original) + "\n");
}
static void forLong() {
    long result, original;
        result = original = 5;
        
        System.out.println("\nlong TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (result*2));
        System.out.println("Division: " + result + " / 2 = " + (result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--); 
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);   
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        System.out.println("Binary inclusive OR assignment: var |= 11 : " + (result |= 11));
        System.out.println("Binary AND assignment: var &= 9 : " + (result &= 9));
        System.out.println("Binary exclusive OR assignment: var ^= 2 : " + (result ^= 2));
        System.out.println("Signed right shift assignment: var >>= 5 : " + (result >>= 5));
        System.out.println("Signed left shift assignment: var <<= 10 : " + (result <<= 10));
        System.out.println("Unsigned right shift assignment: var >>>= 3 : " + (result >>>= 3));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");       
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result == original)
            System.out.println("Equals: " + result + " == " + original + " : True");
        else
            System.out.println("Equals: " + result + " == " + original + " : False");
        if (result != original)
            System.out.println("Not equal to: " + result + " != " + original + " : True\n");
        else
            System.out.println("Not equal to: " + result + " != " + original + " : False\n");
        
        System.out.println("Miscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        System.out.println("Istanceof: Doesn't work for primitive types!\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (result>>>original) + "\n");
}
static void forShort() {
    short result, original;
        result = original = 5;
        
        System.out.println("\nshort TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (short)(result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (short)(result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (short)(result*2));
        System.out.println("Division: " + result + " / 2 = " + (short)(result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (short)(result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        System.out.println("Binary inclusive OR assignment: var |= 11 : " + (result |= 11));
        System.out.println("Binary AND assignment: var &= 9 : " + (result &= 9));
        System.out.println("Binary exclusive OR assignment: var ^= 2 : " + (result ^= 2));
        System.out.println("Signed right shift assignment: var >>= 5 : " + (result >>= 5));
        System.out.println("Signed left shift assignment: var <<= 10 : " + (result <<= 10));
        System.out.println("Unsigned right shift assignment: var >>>= 3 : " + (result >>>= 3));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");       
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result == original)
            System.out.println("Equals: " + result + " == " + original + " : True");
        else
            System.out.println("Equals: " + result + " == " + original + " : False");
        if (result != original)
            System.out.println("Not equal to: " + result + " != " + original + " : True\n");
        else
            System.out.println("Not equal to: " + result + " != " + original + " : False\n");
        
        System.out.println("Miscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        System.out.println("Istanceof: Doesn't work for primitive types!\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (short)(result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (short)(result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (short)(result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (short)(~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (short)(result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (short)(result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (short)(result>>>original) + "\n");
}
static void forByte() {
    byte result, original;
        result = original = 5;
        
        System.out.println("\nbyte TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (byte)(result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (byte)(result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (byte)(result*2));
        System.out.println("Division: " + result + " / 2 = " + (byte)(result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (byte)(result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        System.out.println("Binary inclusive OR assignment: var |= 11 : " + (result |= 11));
        System.out.println("Binary AND assignment: var &= 9 : " + (result &= 9));
        System.out.println("Binary exclusive OR assignment: var ^= 2 : " + (result ^= 2));
        System.out.println("Signed right shift assignment: var >>= 5 : " + (result >>= 5));
        System.out.println("Signed left shift assignment: var <<= 10 : " + (result <<= 10));
        System.out.println("Unsigned right shift assignment: var >>>= 3 : " + (result >>>= 3));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");        
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result == original)
            System.out.println("Equals: " + result + " == " + original + " : True");
        else
            System.out.println("Equals: " + result + " == " + original + " : False");
        if (result != original)
            System.out.println("Not equal to: " + result + " != " + original + " : True\n");
        else
            System.out.println("Not equal to: " + result + " != " + original + " : False\n");
        
        System.out.println("Miscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        System.out.println("Istanceof: Doesn't work for primitive types!\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (byte)(result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (byte)(result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (byte)(result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (byte)(~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (byte)(result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (byte)(result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (byte)(result>>>original) + "\n");
}
static void forChar() {
    char result, original;
        result = original = 'c';
        
        System.out.println("\nchar TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (char)(result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (char)(result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (char)(result*2));
        System.out.println("Division: " + result + " / 2 = " + (char)(result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (char)(result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        System.out.println("Binary inclusive OR assignment: var |= 11 : " + (result |= 11));
        System.out.println("Binary AND assignment: var &= 9 : " + (result &= 9));
        System.out.println("Binary exclusive OR assignment: var ^= 2 : " + (result ^= 2));
        System.out.println("Signed right shift assignment: var >>= 5 : " + (result >>= 5));
        System.out.println("Signed left shift assignment: var <<= 10 : " + (result <<= 10));
        System.out.println("Unsigned right shift assignment: var >>>= 3 : " + (result >>>= 3));
        
        result = 'd';
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");   
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result == original)
            System.out.println("Equals: " + result + " == " + original + " : True");
        else
            System.out.println("Equals: " + result + " == " + original + " : False");
        if (result != original)
            System.out.println("Not equal to: " + result + " != " + original + " : True\n");
        else
            System.out.println("Not equal to: " + result + " != " + original + " : False\n");
        
        System.out.println("Miscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        System.out.println("Istanceof: Doesn't work for primitive types!\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (char)(result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (char)(result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (char)(result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (char)(~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (char)(result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (char)(result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (char)(result>>>original) + "\n");
}
static void forFloat() {
    float result, original;
        result = original = 5;
        
        System.out.println("\nfloat TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (result*2));
        System.out.println("Division: " + result + " / 2 = " + (result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");       
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result == original)
            System.out.println("Equals: " + result + " == " + original + " : True");
        else
            System.out.println("Equals: " + result + " == " + original + " : False");
        if (result != original)
            System.out.println("Not equal to: " + result + " != " + original + " : True\n");
        else
            System.out.println("Not equal to: " + result + " != " + original + " : False\n");
        
        System.out.println("Miscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        System.out.println("Istanceof: Doesn't work for primitive types!");
}
static void forDouble() {
    double result, original;
        result = original = 5;
        
        System.out.println("\ndouble TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (result*2));
        System.out.println("Division: " + result + " / 2 = " + (result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");        
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result == original)
            System.out.println("Equals: " + result + " == " + original + " : True");
        else
            System.out.println("Equals: " + result + " == " + original + " : False");
        if (result != original)
            System.out.println("Not equal to: " + result + " != " + original + " : True\n");
        else
            System.out.println("Not equal to: " + result + " != " + original + " : False\n");
        
        System.out.println("Miscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        System.out.println("Istanceof: Doesn't work for primitive types!");
}
static void forBoolean() {
    boolean result, original;
        result = original = true;
        
        System.out.println("\nboolean TYPE\n");
        
        System.out.println("Assignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));  
        
        System.out.println("\nUnary Operators:\n");
        result = !(original);
        if (result)
            System.out.println("Logical negation: !" + result + " = " + " : False");
        else
            System.out.println("Logical negation: !" + result + " = " + " : True");
        
        System.out.println("\nRelational Operators:\n");              
        if (result == original)
            System.out.println("Equals: " + result + " == " + original + " : True");
        else
            System.out.println("Equals: " + result + " == " + original + " : False");
        if (result != original)
            System.out.println("Not equal to: " + result + " != " + original + " : True\n");
        else
            System.out.println("Not equal to: " + result + " != " + original + " : False\n");
        
        System.out.println("Logical Operators:\n");
        if (result && original)
            System.out.println("AND: " + result + " && " + original + " : True");
        else
            System.out.println("AND: " + result + " && " + original + " : False");
        if (result || original)
            System.out.println("OR: " + result + " || " + original + " : True");
        else
            System.out.println("OR: " + result + " || " + original + " : False");
        
        System.out.println("Miscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " != " + original + " ) ? false : true : " + ((result!=original) ? false : true));
        System.out.println("Istanceof: Doesn't work for primitive types!\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (result^original));
}
static void forIntWrapper() {
    Integer result, original;
        result = original = 5;
        
        System.out.println("\nInteger TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (result*2));
        System.out.println("Division: " + result + " / 2 = " + (result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        System.out.println("Binary inclusive OR assignment: var |= 11 : " + (result |= 11));
        System.out.println("Binary AND assignment: var &= 9 : " + (result &= 9));
        System.out.println("Binary exclusive OR assignment: var ^= 2 : " + (result ^= 2));
        System.out.println("Signed right shift assignment: var >>= 5 : " + (result >>= 5));
        System.out.println("Signed left shift assignment: var <<= 10 : " + (result <<= 10));
        System.out.println("Unsigned right shift assignment: var >>>= 3 : " + (result >>>= 3));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");       
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result.equals(original))
            System.out.println("Equals: " + result + ".equals( " + original + ")" + " : True");
        else
            System.out.println("Equals: " + result + ".equals(" + original + ")" + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        if(original instanceof Integer)
            System.out.println("Istanceof: var instanceof Integer : True\n");
        else
            System.out.println("Istanceof: var instanceof Integer : False\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (result>>>original));
}
static void forLongWrapper() {
    Long result, original;
        result = original = 5L;
        
        System.out.println("\nLong TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (result*2));
        System.out.println("Division: " + result + " / 2 = " + (result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        System.out.println("Binary inclusive OR assignment: var |= 11 : " + (result |= 11));
        System.out.println("Binary AND assignment: var &= 9 : " + (result &= 9));
        System.out.println("Binary exclusive OR assignment: var ^= 2 : " + (result ^= 2));
        System.out.println("Signed right shift assignment: var >>= 5 : " + (result >>= 5));
        System.out.println("Signed left shift assignment: var <<= 10 : " + (result <<= 10));
        System.out.println("Unsigned right shift assignment: var >>>= 3 : " + (result >>>= 3));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");      
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result.equals(original))
            System.out.println("Equals: " + result + ".equals( " + original + ")" + " : True");
        else
            System.out.println("Equals: " + result + ".equals(" + original + ")" + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        if(original instanceof Long)
            System.out.println("Istanceof: var instanceof Long : True\n");
        else
            System.out.println("Istanceof: var instanceof Long : False\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (result>>>original));
}
static void forShortWrapper() {
    Short result, original;
        result = original = 5;
        
        System.out.println("\nShort TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (short)(result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (short)(result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (short)(result*2));
        System.out.println("Division: " + result + " / 2 = " + (short)(result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (short)(result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");       
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
         if (result.equals(original))
            System.out.println("Equals: " + result + ".equals( " + original + ")" + " : True");
        else
            System.out.println("Equals: " + result + ".equals(" + original + ")" + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        if(original instanceof Short)
            System.out.println("Istanceof: var instanceof Short : True\n");
        else
            System.out.println("Istanceof: var instanceof Short : False\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (short)(result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (short)(result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (short)(result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (short)(~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (short)(result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (short)(result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (short)(result>>>original));
}
static void forByteWrapper() {
    Byte result, original;
        result = original = 5;
        
        System.out.println("\nShort TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (byte)(result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (byte)(result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (short)(result*2));
        System.out.println("Division: " + result + " / 2 = " + (byte)(result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (byte)(result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));  
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");        
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
         if (result.equals(original))
            System.out.println("Equals: " + result + ".equals( " + original + ")" + " : True");
        else
            System.out.println("Equals: " + result + ".equals(" + original + ")" + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        if(original instanceof Byte)
            System.out.println("Istanceof: var instanceof Byte : True\n");
        else
            System.out.println("Istanceof: var instanceof Byte : False\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (byte)(result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (byte)(result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (byte)(result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (byte)(~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (byte)(result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (byte)(result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (byte)(result>>>original));
}
static void forCharWrapper() {
    Character result, original;
        result = original = 'c';
        
        System.out.println("\nCharacter TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (char)(result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (char)(result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (char)(result*2));
        System.out.println("Division: " + result + " / 2 = " + (char)(result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (char)(result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));  
        
        result = 'd';
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");     
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
         if (result.equals(original))
            System.out.println("Equals: " + result + ".equals( " + original + ")" + " : True");
        else
            System.out.println("Equals: " + result + ".equals(" + original + ")" + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        if(original instanceof Character)
            System.out.println("Istanceof: var instanceof Character : True\n");
        else
            System.out.println("Istanceof: var instanceof Character : False\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (char)(result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (char)(result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (char)(result^original));
        System.out.println("Unary bitwise complement: " + "~" + result + " = " + (char)(~result));
        System.out.println("Signed right shift: " + result + " >> " + original + " = " + (char)(result>>original));
        System.out.println("Signed left shift: " + result + " << " + original + " = " + (char)(result<<original));
        System.out.println("Unsigned right shift: " + result + " >>> " + original + " = " + (char)(result>>>original));
}
static void forFloatWrapper() {
    Float result, original;
        result = original = 5F;
        
        System.out.println("\nFloat TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (result*2));
        System.out.println("Division: " + result + " / 2 = " + (result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");       
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result.equals(original))
            System.out.println("Equals: " + result + ".equals( " + original + ")" + " : True");
        else
            System.out.println("Equals: " + result + ".equals(" + original + ")" + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        if(original instanceof Float)
            System.out.println("Istanceof: var instanceof Float : True");
        else
            System.out.println("Istanceof: var instanceof Float : False");
}
static void forDoubleWrapper() {
    Double result, original;
        result = original = 5D;
        
        System.out.println("\nDouble TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: " + result + " + " + result + " = " + (result + result));
        System.out.println("Subtraction: " + result + " - 1 = " + (result-1));
        System.out.println("Multiplication: " + result + " * 2 = " + (result*2));
        System.out.println("Division: " + result + " / 2 = " + (result/2));
        System.out.println("Remainder: " + result + " % 7 = " + (result%7));
        
        System.out.println("\nUnary Operators:\n");
        System.out.println("Unary plus: var = +var : " + +result);
        System.out.println("Decrement postfix: var-- : " + result--);
        System.out.println("Decrement prefix: --var : " + --result);
        System.out.println("Increment postifx: var++ : " + result++);
        System.out.println("Increment prefix: ++var : " + ++result);
        System.out.println("Unary minus: var = -var : " + -result);
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));
        System.out.println("Additive assignment: var += 1 : " + (result += 1));
        System.out.println("Subtraction assignment: var -= 8 : " + (result -= 8));
        System.out.println("Multiplication assignment: var *= 7 : " + (result *= 7)); 
        System.out.println("Division assignment: var /= 4 : " + (result /= 4)); 
        System.out.println("Remainder assignment: var %= 6 : " + (result %= 6));
        
        System.out.println("\nRelational Operators:\n");       
        if (!(result>original))
            System.out.println("Greater than: " + result + " > " + original + " : False");
        else
            System.out.println("Greater than: " + result + " > " + original + " : True");       
        if (!(result>=original))
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : False");
        else
            System.out.println("Greater than or equal to: " + result + " >= " + original + " : True");      
        if (result<original)
            System.out.println("Less than: " + result + " < " + original + " : True");
        else
            System.out.println("Less than: " + result + " < " + original + " : False");       
        if (result<=original)
            System.out.println("Less than or equal to: " + result + " <= " + original + " : True");
        else
            System.out.println("Less than or equal to: " + result + " <= " + original + " : False");               
        if (result.equals(original))
            System.out.println("Equals: " + result + ".equals( " + original + ")" + " : True");
        else
            System.out.println("Equals: " + result + ".equals(" + original + ")" + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = " + "( " + result + " > " + original + " ) ? " + result + " : " + original + " : " + ((result>original) ? result : original));
        if(original instanceof Double)
            System.out.println("Istanceof: var instanceof Double : True");
        else
            System.out.println("Istanceof: var instanceof Double : False");
}
static void forBooleanWrapper() {
    Boolean result, original;
        result = original = true;
        
        System.out.println("\nboolean TYPE\n");
        
        System.out.println("Assignement Operators:\n");
        System.out.println("Simple assignment: var = " + (result = original));  
        
        System.out.println("\nUnary Operators:\n");
        result = !(original);
        if (result)
            System.out.println("Logical negation: !" + result + " = " + " : False");
        else
            System.out.println("Logical negation: !" + result + " = " + " : True");
        
        System.out.println("\nRelational Operators:\n");              
        if (result.equals(original))
            System.out.println("Equals: " + result + ".equals( " + original + ")" + " : True");
        else
            System.out.println("Equals: " + result + ".equals(" + original + ")" + " : False");
        
        System.out.println("Logical Operators:\n");
        if (result && original)
            System.out.println("AND: " + result + " && " + original + " : True");
        else
            System.out.println("AND: " + result + " && " + original + " : False");
        if (result || original)
            System.out.println("OR: " + result + " || " + original + " : True");
        else
            System.out.println("OR: " + result + " || " + original + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = " + result + ".equals(" + original + ") ? " + result + " : " + original + " : " + ((result.equals(original) ? result : original)));
        if(original instanceof Boolean)
            System.out.println("Istanceof: var instanceof Boolean : True\n");
        else
            System.out.println("Istanceof: var instanceof Boolean : False\n");
 
        System.out.println("Binary Operators:\n");
        System.out.println("Bitwise inclusive OR: " + result + " | " + original + " = " + (result|original));
        System.out.println("Bitwise AND: " + result + " & " + original + " = " + (result&original));
        System.out.println("Bitwise exclusive OR: " + result + " ^ " + original + " = " + (result^original));
}
static void forString() {
    String result, original;
        result = "This is";
        original = " a string!";
        
        System.out.println("\nString TYPE\n");
        System.out.println("Arithmetic Operators\n");        
        System.out.println("Additive: \"" + result + "\" + \"" + original + "\" = \"" + (result + original) + "\"");
        
        System.out.println("\nAssignement Operators:\n");
        System.out.println("Simple assignment: var = \"" + (result = result) + "\"");
        System.out.println("Additive assignment: \"" + result + "\" += \"" + original + "\" : " + (result += original));      
           
        result = "This is";
        if (result.equals(original))
            System.out.println("Equals: \"" + result + "\".equals(\"" + original + "\")" + " : True");
        else
            System.out.println("Equals: \"" + result + "\".equals(\"" + original + "\")" + " : False");
        
        System.out.println("\nMiscellaneous operator:\n");
        System.out.println("Ternary: var = \"" + result + "\".equals(\"" + original + "\") ? \"" + result + "\" : \"" + original + "\" : \"" + ((result.equals(original) ? result : original)) + "\"");
        if(original instanceof String)
            System.out.println("Istanceof: var instanceof String : True\n");
        else
            System.out.println("Istanceof: var instanceof String : False\n");
}
static void menu() {
    System.out.println("\n1. int \t\t2. long \t3. short \t4. byte \n"
            + "5. char \t6. float \t7. double \t8. boolean \n"
            + "9. Integer \t10. Long \t11. Short \t12. Byte \n"
            + "13. Character \t14. Float \t15. Double \t16. Boolean \n"
            + "17. String \t18. Exit \t19. All\n");
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("Choice: ");
    String string = scanner.nextLine();
    
    Switch.doParse(string);
    
    menu();
}
}