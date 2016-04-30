
public class Argument<K, V> implements ArgumentPair{
	private K key;
	private V value;
	
	public Argument(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {return key;}
	public V getValue() { return value;}
}
