class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """

        def dfs(image, i, j, new_color):
            og_color = image[i][j]

            if image[i][j] == new_color:
                return None
            
            image[i][j] = new_color

            if i - 1 >= 0 and image[i-1][j] == og_color:
                dfs(image, i-1, j, new_color)
            if i + 1 < len(image) and image[i+1][j] == og_color:
                dfs(image, i+1, j, new_color)
            if j - 1 >= 0 and image[i][j-1] == og_color:
                dfs(image, i, j-1, new_color)
            if j + 1 < len(image[0]) and image[i][j+1] == og_color:
                dfs(image, i, j+1, new_color)

        dfs(image,sr,sc, color)
        return image