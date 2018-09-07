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

package com.gd.smartcard;

import javax.smartcardio.CardException;

    
/**
 *
 * @author Julio
 */
public class SCardListReaders {
    
    private String [] sCReader;
    
    /**
     * Clase SCardListReaders contiene metodos públicos y variables locales para
     * listar los lectores PC/SC conectados
     * @throws CardException 
     */
    public SCardListReaders() throws CardException {
       setSCReader();
    }    

    /**
     * Utilizado para explorar y verificar los conectores PC/SC conectados
     * @throws CardException 
     */
    private synchronized void setSCReader() throws CardException {        
        SCardConexion c = new SCardConexion();
        String[] r = new String[c.terminals().size()];
        for (int i = 0; i < c.terminals().size(); i++)
            r[i] = c.terminals().get(i).getName();
        this.sCReader = r;
    }

    /**
     * Metodo getSCReader
     * @return Devuelve los lectores PC/SC conectados
     */
    public String[] getSCReader() {
        return this.sCReader;
    }    
    
}