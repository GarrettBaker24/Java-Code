package CodeStructure4;

public class Invalid<T>
{
		
		public Node<T> front;
		public Node<T> back;
		
		
		
		public Invalid(T value)
		{
			Node<T> node = new Node<T>(value);
			front = node;
			back = node;
			
		}
		
		
		public void push(T value) 
		{
			if(front == null)
			{
				Node<T> node = new Node<T>(value);
				front = back = node;
			}
			else
			{
				Node<T> node = new Node<T>(value);
				
				node.next = back;

				back.prev = node;

				back = node;
			}
		}
		
		
		public T pop()
		{
			if(front == back)
			{
				T returnValue = front.value;
				front = back = null;
				
				return returnValue;
				
			}
			else
			{
				T returnValue = front.value;
				front = front.prev;

				front.next = null;

				return returnValue;
			}
		}


		
		
	
	
	
	

}
