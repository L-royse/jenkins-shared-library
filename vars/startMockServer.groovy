def call() {
    sh '''
        cd project
        nohup python3 mock_server.py > mock.log 2>&1 &
        echo $! > mock.pid
        sleep 3
        cat mock.log
        curl -s http://127.0.0.1:5000/posts | head -c 200
    '''
}