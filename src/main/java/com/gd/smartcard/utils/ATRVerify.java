/* 
 * Version 1.9 Revision 1
 * 
 * 01/09/2018
 *
 * Copyright 2013-2018 GIGADATTA, S.A.
 * Julio Francisco Chinchilla Valenzuela
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.gd.smartcard.utils;

import javax.smartcardio.ATR;
 
 
 
/**
* Clase para verificación de ATR
* @version 1.9 Septiembre de 2018
* @author Julio Chinchilla
*/
public class ATRVerify {
    
    
    /**
     * Función que recibe un objeto ATR separa los bytes T0 hasta TJ en
     * el byte array check, luego utiliza la función getXORCheckSumValue
     * para obtener la suma verificativa y lo compara con el byte TCK,
     * si los bytes coinciden la respuesta será true de lo contrario será
     * false, y el ATR a verificar estará incorrecto
     * @param atr ATR con espacios entre bytes
     * @return
     */
    public static boolean checkATR (ATR atr) {
        return checkATR(atr.getBytes());
    }
    
    /**
     * Función que recibe un arreglo de bytes separa los bytes T0 hasta TJ en
     * el byte array check, luego utiliza la función getXORCheckSumValue
     * para obtener la suma verificativa y lo compara con el byte TCK,
     * si los bytes coinciden la respuesta será true de lo contrario será
     * false, y el ATR a verificar estará incorrecto
     * @param atr ATR con espacios entre bytes
     * @return
     */
    public static boolean checkATR (byte[] atr) {
        byte[] check = new byte[atr.length-4];
        System.arraycopy(atr, 1, check, 0, check.length);
        return getXORCheckSumValue(check) == atr[atr.length-1];
    }
 
    
    /**
     * Función que realiza una suma de verificación a una arreglo de bytes
     * utilizando el operador XOR
     * @param bytes Cadena String en formato hexadecimal a analizar
     * @see <a href="http://es.wikipedia.org/wiki/Suma_de_verificaci%C3%B3n"&gt;WikiES: Suma de verificación</a&gt;
     * @return String de comprobación mediante Suma de Verificación HEX
     */
    private static final byte getXORCheckSumValue(byte[] bytes) {
        byte sum = 0;
        for (byte b : bytes)
            sum ^= b;        
        return sum;
    }
 
}