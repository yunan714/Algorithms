package String;

//AC自动机的实现
public class AC_auto_machine {
    class TridForAc<T>{
        private TridForAc<T> root;
        private int deep;

        public TridForAc(){
            root = new TridNode<T>();
        }

        public int getDeep(){
            return deep;
        }

        /**
         * 给定byte[]和value，将key构建在树中
         * 同时把结果保存在叶子节点的resultSet中
         */
        public boolean addNode(byte[] key, T value){
            
        }
    }
}
