def call(Map config = [:]) {
    def env = config.get('env', 'dev')
    def parallel = config.get('parallel', true)
    def withCoverage = config.get('withCoverage', true)

    def nFlag = parallel ? '-n auto' : ''
    def covFlag = withCoverage ? '--cov=api --cov-report=xml:coverage.xml --cov-report=html:htmlcov' : ''

    sh """
        cd project
        TEST_ENV=${env} pytest tests_api/ -v ${nFlag} ${covFlag} \
            --alluredir=allure-results
    """
}