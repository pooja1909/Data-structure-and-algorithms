/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class WordDict
{
public static final int Letters = 26,Words=Letters*Letters;
private String word;

public int hashcode()
{
    return Letters* (word.charAt(0)-'a')+(word.charAt(1)-'a');
    
}

}

public class Dict
{
    private Definition[] deftable =new Definition[Word.WORDS];
    
}
