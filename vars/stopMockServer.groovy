def call() {
    sh '''
        if [ -f project/mock.pid ]; then
            kill $(cat project/mock.pid) || true
            rm -f project/mock.pid
        fi
    '''
}