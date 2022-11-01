import java.util.EmptyStackException;

public class MyStack implements MyStackInterface {

  public int size;
  public int defaultSize = 10;
  public int[] list;

  public MyStack() {
    size = 0;
    list = new int[defaultSize];
  }

  
  public int size() {
    return size;
  }

  public boolean empty() {
    if (size() <= 0) {
      return true;
    }
    return false;
  }

  public void push(int num) {

    if (list.length == size()) {
        more(size() * 2 + 1);
      }
      for (int x = size(); x > size; x--) {
        list[x] = list[x - 1];
      }
      list[size] = num;
      size++;

  }

  public int peek() {
    if (empty()) {
      throw new EmptyStackException();
    } else {
      return list[size-1];
    }
  }

  public int pop() {
    if (empty()) {
      throw new EmptyStackException();
    } else {
      int removed = list[size-1];
      for (int x = size-1; x < size() - 1; x++) {
        list[x] = list[x + 1];

      }
      size--;
      return removed;
    }
  }

  public int search(int num) {
    for (int x = size-1; x > 0; x--)
      {
        if (list[x] == num)
        {
          return size - x;
        }
      }
    return -1;
  }

  public int[] toArray() {
    int[] n = new int[size];
    for (int x = 0; x < size; x++) {
      n[x] = list[x];
    }
    return n;

  }

  public void more(int num) {
    if (num < size) {
      return;
    }
    int[] n = list;
    list = new int[num];
    for (int x = 0; x < size(); x++) {
      list[x] = n[x];
    }
  }
}
