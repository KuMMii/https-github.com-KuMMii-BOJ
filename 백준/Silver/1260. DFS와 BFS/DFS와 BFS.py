from collections import deque

def dfs(graph, v, visited):
    visited[v]=True
    print(v,end=" ")
    for i in sorted(graph[v]):
        if not visited[i]:
            dfs(graph, i, visited)
    
            
def bfs(graph, start, visited):
    visited[start]=True
    queue=deque([start])
    
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        
        for i in sorted(graph[v]):
            if not visited[i]:
                queue.append(i)
                visited[i]=True


N, M, S = map(int, input().split())

graph=[[] for _ in range(N+1)]
for i in range(M):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)
    

visited=[False]*(N+1)
dfs(graph, S, visited)
print()
visited=[False]*(N+1)
bfs(graph,S, visited)            