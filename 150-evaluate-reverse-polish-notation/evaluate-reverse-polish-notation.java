class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int a, b;
        for (String token: tokens) {
            switch (token) {
                case "+":
                    stack.offer(stack.pollLast() + stack.pollLast());
                    break;
                case "-":
                    b = stack.pollLast();
                    a = stack.pollLast();
                    stack.offer(a-b);
                    break;
                case "*":
                    stack.offer(stack.pollLast() * stack.pollLast());
                    break;
                case "/":
                    b = stack.pollLast();
                    a = stack.pollLast();
                    stack.offer(a/b);
                    break;
                default:
                    // operand --> number
                    stack.offer(Integer.parseInt(token));
            }
        }
        return stack.poll();
    }
}