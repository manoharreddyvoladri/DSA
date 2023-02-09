class Solution {
public:
    bool checkInclusion(string p, string s) {
        int n = s.length(), m = p.length();
        vector<int> frs(26,0),frp(26,0);
        if(n<m) return false;
        for(int i=0;i<m;i++){
            frs[s[i]-'a']++;
            frp[p[i]-'a']++;
        }
        if(frs==frp){
            return true;
        }
        for(int i=m;i<n;i++){
            frs[s[i-m]-'a']--;
            frs[s[i]-'a']++;
            if(frs==frp){
                return true;
            }
        }
        return false;
    }
};