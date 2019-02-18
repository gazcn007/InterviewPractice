# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        :type root: TreeNode
        :rtype: str
        """
        if root == None:
            return "{}"
        queue = []
        queue.append(root)
        for node in queue:
            if node == None:
                continue
            queue.append(node.left)
            queue.append(node.right)
        while queue[-1] == None:
            queue.pop()
        sb = "{" + str(queue[0].val)
        for i in range(1, len(queue)):
            if queue[i] == None:
                sb = sb + ",#"
            else:
                sb = sb + "," + str(queue[i].val)
        sb = sb + "}"
        return sb


    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        """
        if data[0] != "{" or data [-1] != "}":
            return None
        elif data == "{}":
            return None

        str_list = data[1:-1].split(',')
        queue = []
        root = TreeNode(int(str_list[0]))
        queue.append(root)
        index = 0
        for i in range (1, len(str_list)):
            if(str_list[i]!="#"):
                node = TreeNode(int(str_list[i]))
                if i%2 == 1:
                    queue[index].left = node
                else:
                    queue[index].right = node
                queue.append(node)
            if i%2 == 0:
                index += 1
        return root
        

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = None
root.left.right = None
root.right.left = TreeNode(4)
root.right.right = TreeNode(5)

# Your Codec object will be instantiated and called as such:
codec = Codec()
temp = codec.serialize(root)
print(temp)
node = codec.deserialize(temp)
temp = codec.serialize(node)
print(temp)