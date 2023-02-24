package com.learn.dogs.config



//@Configuration
//@EnableR2dbcRepositories
class DatastoreConfig {

}
  /*  : AbstractR2dbcConfiguration() {
    @Value("\${spring.r2dbc.name}")
    private val userName: String = ""

    @Value("\${spring.r2dbc.password}")
    private val password: String = ""

    @Value("\${spring.r2dbc.url}")
    private val dbName: String = ""

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return H2ConnectionFactory(
            ConnectionFactoryBuilder.withUrl(dbName)

            .username(userName)
            .password(password)
            .build())
    }


    private val logger: Logger = getLogger(javaClass)
    private var DB_UUID: String = "testdb"

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        val originDataSource = dataSource().unwrap(SimpleDriverDataSource::class.java)

        val config = ConnectionFactories.get(ConnectionFactoryOptions.builder()
            .option(ConnectionFactoryOptions.DRIVER, "h2")
            .option(ConnectionFactoryOptions.PROTOCOL, "mem")
            .option(ConnectionFactoryOptions.DATABASE, DB_UUID)
            .option(ConnectionFactoryOptions.USER, originDataSource.username!!)
            .option(ConnectionFactoryOptions.PASSWORD, originDataSource.password!!)
            .build())

        val queryFormatter = QueryExecutionInfoFormatter.showAll()

        return ProxyConnectionFactory.builder(config)
            // Log executed query information
            .onAfterQuery{queryExecInfo ->  queryExecInfo
                .map(queryFormatter::format)
                .map(logger::trace)
                .subscribe()
            }.build()
    }

    /**
     * Enable SQL Schema generation via Liquibase. A dataSource is needed for this
     */
    @Bean
    fun dataSource(): DataSource = EmbeddedDatabaseBuilder()
        .setName(dbName)
        .setType(EmbeddedDatabaseType.H2)
        .ignoreFailedDrops(true)
        .build()
}*/