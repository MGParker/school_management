package za.ac.cput.service;

class EmployeeAddressServiceImplTest {

//    private Address address;
//    private City city;
//    private Country country;
//    private EmployeeAddress employeeAddress;
//    private IEmployeeAddressService service;
//    private EmployeeAddress.EmployeeAddressID employeeAddressID;
//
//    @BeforeEach
//    void setUp() {
//        this.country = CountryFactory.build("2055","South Africa");
//        this.city = CityFactory.build("2055", "Cape Town",country);
//        this.address = AddressFactory.createAddress("10","5","14","Johnson",7800,city);
//        this.employeeAddress = EmployeeAddressFactory.createEmployeeAddress("2055",address);
//        this.employeeAddressID = EmployeeAddressFactory.buildID(this.employeeAddress);
//        this.service = EmployeeAddressServiceImpl.getService();
//    }
//
//    @AfterEach
//    void tearDown(){
//        this.service.delete(this.employeeAddress);
//    }
//
//    @Test
//    void save() {
//        EmployeeAddress saved = this.service.save(this.employeeAddress);
//        System.out.println(saved);
//        assertNotNull(saved);
//        assertSame(this.employeeAddress, saved);
//    }
//
//    @Test
//    void read() {
//        EmployeeAddress saved = this.service.save(this.employeeAddress);
//        Optional<EmployeeAddress> read = this.service.read(this.employeeAddressID);
//        assertAll(
//                ()->assertTrue(read.isPresent()),
//                ()->assertSame(saved, read.get())
//        );
//    }
//
//    @Test
//    void delete() {
//        EmployeeAddress saved = this.service.save(this.employeeAddress);
//        this.service.delete(saved);
//        List<EmployeeAddress> employeeAddressSet = this.service.getAll();
//        assertEquals(0,employeeAddressSet.size());
//    }
//
//    @Test
//    void getAll() {
//        this.service.save(this.employeeAddress);
//        List<EmployeeAddress> employeeAddressSet = this.service.getAll();
//        assertEquals(1,employeeAddressSet.size());
//    }
}