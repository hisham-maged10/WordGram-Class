/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
public class WordGram implements Comparable<WordGram>
{
	private String[] words;
	
	public WordGram(String[] source)
	{
		this.words=new String[source.length];
		//this.words=new String[size];
		//System.arraycopy(source,0,words,start,size);
		System.arraycopy(source,0,words,0,source.length);
	}
	public String wordAt(int index)
	{
		if(index<0 || index>this.words.length-1)
			throw new IndexOutOfBoundsException("Invalid index: "+index);
		return words[index];
	}
	public String get(int index)
	{
		if(index<0 || index>this.words.length-1)
			throw new IndexOutOfBoundsException("Invalid index: "+index);
		return words[index];
	}
	public int length()
	{
		return this.words.length;
	}
	@Override
	public int compareTo(WordGram another)
	{
		if(this.length()!=another.length())
			return this.length()-another.length();
		int result=0;
		for(int i=0;i<words.length;i++)
			result+=(this.wordAt(i).compareTo(another.wordAt(i)));
		if(result <0)
			return -1;
		else if(result>0)
			return 1;
		else
			return 0;
	}
	@Override
	public boolean equals(Object o)
	{
		WordGram another=(WordGram) o;
		if(this.length()!=another.length()) return false;
		for(int i=0,n=this.length();i<n;i++)
			if(!this.wordAt(i).equals(another.wordAt(i)))
				return false;
		return true;
	}
	public boolean equalsIgnoreCase(WordGram another)
	{
		if(this.length()!=another.length()) return false;
		for(int i=0,n=this.length();i<n;i++)
			if(!this.wordAt(i).equalsIgnoreCase(another.wordAt(i)))
				return false;
		return true;
	}
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append('[');;
		for(int i=0;i<this.words.length;i++)
			sb.append(" "+words[i]+(i!=this.words.length-1)?",":"]");
		return sb.toString();
	}
	@Override
	public int hashCode()
	{
		return this.toString().hashCode();
		
	}
	public WordGram shiftAdd(String word)
	{
		String[] other=new String[this.words.length];
		System.arraycopy(this.words,0,other,0,other.length);
		for(int i=0;i<other.length-1;i++)
			other[i]=other[i+1];
		other[other.length-1]=word;
		return new WordGram(other);
	}
}
